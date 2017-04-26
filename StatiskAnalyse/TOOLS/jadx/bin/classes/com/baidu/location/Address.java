package com.baidu.location;

import com.baidu.location.b.b;

public final class Address implements b {
    public final String address;
    public final String city;
    public final String cityCode;
    public final String country;
    public final String countryCode;
    public final String district;
    public final String province;
    public final String street;
    public final String streetNumber;

    public static class Builder {
        private static final String a = "上海";
        private static final String case = "重庆";
        private static final String do = "北京";
        private static final String int = "天津";
        private String byte = null;
        private String char = null;
        private String else = null;
        private String for = null;
        private String goto = null;
        private String if = null;
        private String long = null;
        private String new = null;
        private String try = null;

        public Address build() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.new != null) {
                stringBuffer.append(this.new);
            }
            if (this.if != null) {
                stringBuffer.append(this.if);
            }
            if (!(this.if == null || this.byte == null || ((this.if.contains(do) && this.byte.contains(do)) || ((this.if.contains(a) && this.byte.contains(a)) || ((this.if.contains(int) && this.byte.contains(int)) || (this.if.contains(case) && this.byte.contains(case))))))) {
                stringBuffer.append(this.byte);
            }
            if (this.goto != null) {
                stringBuffer.append(this.goto);
            }
            if (this.else != null) {
                stringBuffer.append(this.else);
            }
            if (this.for != null) {
                stringBuffer.append(this.for);
            }
            if (stringBuffer.length() > 0) {
                this.long = stringBuffer.toString();
            }
            return new Address();
        }

        public Builder city(String str) {
            this.byte = str;
            return this;
        }

        public Builder cityCode(String str) {
            this.char = str;
            return this;
        }

        public Builder country(String str) {
            this.new = str;
            return this;
        }

        public Builder countryCode(String str) {
            this.try = str;
            return this;
        }

        public Builder district(String str) {
            this.goto = str;
            return this;
        }

        public Builder province(String str) {
            this.if = str;
            return this;
        }

        public Builder street(String str) {
            this.else = str;
            return this;
        }

        public Builder streetNumber(String str) {
            this.for = str;
            return this;
        }
    }

    private Address(Builder builder) {
        this.country = builder.new;
        this.countryCode = builder.try;
        this.province = builder.if;
        this.city = builder.byte;
        this.cityCode = builder.char;
        this.district = builder.goto;
        this.street = builder.else;
        this.streetNumber = builder.for;
        this.address = builder.long;
    }
}
