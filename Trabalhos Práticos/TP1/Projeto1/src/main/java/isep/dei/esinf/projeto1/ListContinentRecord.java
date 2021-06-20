/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isep.dei.esinf.projeto1;

/**
 *
 * @author 1190402_1191045
 */
public final class ListContinentRecord {

    private Location location;
    private Record record;

    public ListContinentRecord(Location location, Record record) {
        setLocation(location);
        setRecord(record);
    }

    /**
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @return the record
     */
    public Record getRecord() {
        return record;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * @param record the record to set
     */
    public void setRecord(Record record) {
        this.record = record;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Location: ");
        s.append(location);
        s.append("; Record: ");
        s.append(record);
        s.append(";\n");
        return s.toString();
    }

}
