package com.example.yugandhar_pc.databindingexample;

import java.util.List;

public class Check {

    private List<HeroesBean> heroes;

    public List<HeroesBean> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<HeroesBean> heroes) {
        this.heroes = heroes;
    }

    public static class HeroesBean {
        /**
         * name : Spiderman
         * imageurl : https://simplifiedcoding.net/demos/view-flipper/images/spiderman.jpg
         */

        private String name;
        private String imageurl;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImageurl() {
            return imageurl;
        }

        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }
    }
}
