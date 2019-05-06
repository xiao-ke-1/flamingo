package org.hootina.platform.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import org.hootina.platform.model.Contacts;
import org.hootina.platform.result.ChatSession;

import org.hootina.platform.db.ContactsDao;
import org.hootina.platform.db.ChatSessionDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig contactsDaoConfig;
    private final DaoConfig chatSessionDaoConfig;

    private final ContactsDao contactsDao;
    private final ChatSessionDao chatSessionDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        contactsDaoConfig = daoConfigMap.get(ContactsDao.class).clone();
        contactsDaoConfig.initIdentityScope(type);

        chatSessionDaoConfig = daoConfigMap.get(ChatSessionDao.class).clone();
        chatSessionDaoConfig.initIdentityScope(type);

        contactsDao = new ContactsDao(contactsDaoConfig, this);
        chatSessionDao = new ChatSessionDao(chatSessionDaoConfig, this);

        registerDao(Contacts.class, contactsDao);
        registerDao(ChatSession.class, chatSessionDao);
    }
    
    public void clear() {
        contactsDaoConfig.clearIdentityScope();
        chatSessionDaoConfig.clearIdentityScope();
    }

    public ContactsDao getContactsDao() {
        return contactsDao;
    }

    public ChatSessionDao getChatSessionDao() {
        return chatSessionDao;
    }

}