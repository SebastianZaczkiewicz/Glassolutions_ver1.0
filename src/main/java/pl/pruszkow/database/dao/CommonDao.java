package pl.pruszkow.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.sun.javafx.tools.packager.Log;
import pl.pruszkow.database.models.BaseModel;

import java.sql.SQLException;

public abstract class CommonDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonDao.class);
    protected final  ConnectionSource connectionSource;

    public CommonDao(ConnectionSource connectionSource) { this.connectionSource = connectionSource;}



    public <T extends BaseModel, I>void creatOrUpdate(BaseModel baseModel){
        Dao<T, I> dao = getDao((Class<T>) baseModel.getClass());
        try {
            dao.createOrUpdate((T) baseModel);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    public <T extends BaseModel, I>void refresh(BaseModel baseModel){
        Dao<T, I> dao = getDao((Class<T>) baseModel.getClass());
        try {
            dao.refresh((T) baseModel);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    public <T extends BaseModel, I>void delete(BaseModel baseModel){
        Dao<T, I> dao = getDao((Class<T>) baseModel.getClass());
        try {
            dao.delete((T) baseModel);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    public <T extends BaseModel, I>void queryForAll(BaseModel baseModel){
        Dao<T, I> dao = getDao((Class<T>) baseModel.getClass());
        try {
            dao.queryForAll();
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    //Uniwersalne Dao dla karzdej klasy która rozszeża BaseMOdel

    public <T extends BaseModel, I> Dao <T, I> getDao(Class<T> cls){

        try {
            return DaoManager.createDao(connectionSource, cls);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
        return null;
    }

}
