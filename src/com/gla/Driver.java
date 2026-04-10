package com.gla;

    public class Driver {
        String name;
        String id;
        RouteLinkedList<Checkpoint> route;

        public Driver(String name, String id) {
            this.name = name;
            this.id = id;
            this.route = new RouteLinkedList<>();
        }
    }
}
