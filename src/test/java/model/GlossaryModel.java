package model;

import com.google.gson.annotations.SerializedName;

public class GlossaryModel {

    private String title;
    @SerializedName("gloss_div")
    private GlossDiv glossDiv;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GlossDiv getGlossDiv() {
        return glossDiv;
    }

    public void setGlossDiv(GlossDiv glossDiv) {
        this.glossDiv = glossDiv;
    }


    public static class GlossDiv {
        private String title;
        private boolean flag;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }
    }

}
