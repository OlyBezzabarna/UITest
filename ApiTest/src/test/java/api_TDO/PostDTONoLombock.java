package api_TDO;

import lombok.Builder;

import java.util.List;

public class PostDTONoLombock {

    private LocationDTO location;
    private Integer accuracy;
    private String name;
    private String phone_number;
    private String address;
    private List<String> types;
    private String website;
    private String language;

    public PostDTONoLombock(Builder builder) {
        this.location = builder.location;
        this.accuracy = builder.accuracy;
        this.name = builder.name;
        this.phone_number = builder.phone_number;
        this.address = builder.address;
        this.types = builder.types;
        this.website = builder.website;
        this.language = builder.language;
    }

    public LocationDTO getLocation() {
        return location;
    }

    public Integer getAccuracy() {
        return accuracy;
    }

    public String getName() {
        return name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getAddress() {
        return address;
    }

    public List<String> getTypes() {
        return types;
    }

    public String getWebsite() {
        return website;
    }

    public String getLanguage() {
        return language;
    }

    public static class Builder {
        private LocationDTO location;
        private Integer accuracy;
        private String name;
        private String phone_number;
        private String address;
        private List<String> types;
        private String website;
        private String language;

        public Builder() {
        }

        public Builder withLocation(LocationDTO location) {
            this.location = location;
            return this;
        }

        public Builder withAccuracy(Integer accuracy) {
            this.accuracy = accuracy;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withPhoneNumber(String phone_number) {
            this.phone_number = phone_number;
            return this;
        }

        public Builder withAddress(String address) {
            this.address  = address;
            return this;
        }

        public Builder withTypes(List<String> types) {
            this.types = types;
            return this;
        }

        public Builder withWebsite(String website) {
            this.website = website;
            return this;
        }

        public Builder withLanguage(String language) {
            this.language = language;
            return this;
        }

        public PostDTONoLombock build() {
            return new PostDTONoLombock(this);

        }
    }
}
