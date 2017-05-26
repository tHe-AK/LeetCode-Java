public class FileSystem {
    private class File {
        public boolean isFile;
        public Map<String, File> files;
        public String content;
        
        public File() {
            isFile = false;
            files = new HashMap<>();
            content = "";
        }
    }
    
    private File root;
    
    public FileSystem() {
        root = new File();
    }
    
    public List<String> ls(String path) {
        File file = root;
        List<String> files = new ArrayList<>();

        if (!path.equals("/")) {
            String[] strs = path.split("/");
            
            for (int i = 1; i < strs.length; i++) {
                file = file.files.get(strs[i]);
            }
            
            if (file.isFile) {
                files.add(strs[strs.length - 1]);
                return files;
            }
        }
        
        files = new ArrayList<>(file.files.keySet());
        Collections.sort(files);
        return files;
    }
    
    public void mkdir(String path) {
        File file = root;
        String[] strs = path.split("/");

        for (int i = 1; i < strs.length; i++) {
            file.files.putIfAbsent(strs[i], new File());
            file = file.files.get(strs[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        File file = root;
        String[] strs = filePath.split("/");

        for (int i = 1; i < strs.length; i++) {
            file.files.putIfAbsent(strs[i], new File());
            file = file.files.get(strs[i]);
        }
        
        file.isFile = true;
        file.content += content;
    }
    
    public String readContentFromFile(String filePath) {
        File file = root;
        String[] strs = filePath.split("/");

        for (int i = 1; i < strs.length; i++) {
            file = file.files.get(strs[i]);
        }
        
        return file.content;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
