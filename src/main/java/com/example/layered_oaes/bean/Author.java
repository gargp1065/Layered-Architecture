package com.example.layered_oaes.bean;

import java.util.List;

public class Author {
        private String username;
        private String password;
        public Author(){}
        public Author(String username, String password, List<Item> items) {
            this.username = username;
            this.password = password;
            this.items = items;
        }

        private List<Item> items;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }
}
