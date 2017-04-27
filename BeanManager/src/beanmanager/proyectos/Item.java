/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanmanager.proyectos;

/**
 *
 * @author ascencio
 */
class Item
    {
        private int id;
        private String description,ID;
 
        public Item(int id, String description)
        {
            this.id = id;
            this.description = description;
        }

        public Item(String id, String description)
        {
            this.ID = id;
            this.description = description;
        }
 
        public int getId()
        {
            return id;
        }
        public String getID()
        {
            return ID;
        }
 
        public String getDescription()
        {
            return description;
        }
 
        public String toString()
        {
            return description;
        }
    }
