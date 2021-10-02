package ObserverDesignPattern.newpackage;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adameinstein
 */
public interface Observer {
    public void update(String location, String description);
    /** Called from DEA and Cartel */
    String getLog();
}
