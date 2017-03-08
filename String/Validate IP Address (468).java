public class Solution {
    public String validIPAddress(String IP) {
        if (isValidIPv4(IP)) {
            return "IPv4";
	    } else if (isValidIPv6(IP)) {
	        return "IPv6";
	    } else {
	        return "Neither";
	    }
    }
    
    private boolean isValidIPv4(String ip) {
    	if (ip.length() < 7 || ip.length() > 15) {
    	    return false;
    	}
    	
    	if (ip.charAt(0) == '.' || ip.charAt(ip.length() - 1) == '.') {
    	    return false;
    	}
    	
    	String[] tokens = ip.split("\\.");
    	
    	if (tokens.length != 4) {
    	    return false;
    	}
    	
    	for (String token : tokens) {
    		if (!isValidIPv4Token(token)) {
    		    return false;
    		}
    	}
    	
    	return true;
    }
    
    private boolean isValidIPv4Token(String token) {
    	if (token.length() < 1 || token.length() > 3) {
    	    return false;
    	}
    	
    	if (token.charAt(0) == '0' && token.length() > 1) {
    	    return false;
    	}
    	
    	if (token.charAt(0) == '-') {
    	    return false;
    	}
    	
    	try {
    		int num = Integer.parseInt(token);
    		
    		if (num > 255) {
    		    return false;
    		}
    	} catch (NumberFormatException e) {
    		return false;
    	}
    	
    	return true;
    }
    
    private boolean isValidIPv6(String ip) {
    	if (ip.length() < 15 || ip.length() > 39) {
    	    return false;
    	}
    	
    	if (ip.charAt(0) == ':' || ip.charAt(ip.length() - 1) == ':') {
    	    return false;
    	}
    	
    	String[] tokens = ip.split(":");
    	
    	if (tokens.length != 8) {
    	    return false;
    	}
    	
    	for (String token: tokens) {
    		if (!isValidIPv6Token(token)) {
    		    return false;
    		}
    	}
    	
    	return true;
    }
    
    private boolean isValidIPv6Token(String token) {
    	if (token.length() < 1 || token.length() > 4) {
    	    return false;
    	}
    	
    	char[] chars = token.toCharArray();
    	
    	for (char c : chars) {
    	    if (!Character.isDigit(c) && !(c >= 'a' && c <= 'f') && !(c >= 'A' && c <= 'F')) {
    			return false;
    	    }
    	}
    	
    	return true;
    }
}
