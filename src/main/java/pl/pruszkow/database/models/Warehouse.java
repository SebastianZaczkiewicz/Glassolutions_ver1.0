package pl.pruszkow.database.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable (tableName = "WAREHOUSE")
public class Warehouse implements BaseModel {
    public Warehouse(){
    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "LOCATION", canBeNull = false)
    private  String location;

    @DatabaseField(columnName = "INFO_WAREHOUSE")
    private String infoWarehouse;

    @ForeignCollectionField(eager = true)
    private ForeignCollection<Samples>samples;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public String getInfoWarehouse() { return infoWarehouse; }

    public void setInfoWarehouse(String infoWarehouse) { this.infoWarehouse = infoWarehouse; }

    public ForeignCollection<Samples> getSamples() { return samples; }

    public void setSamples(ForeignCollection<Samples> samples) { this.samples = samples; }
}
