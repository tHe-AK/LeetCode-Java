class Solution {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}

class Solution {
    public String defangIPaddr(String address) {
        return String.join("[.]", address.split("\\."));
    }
}
