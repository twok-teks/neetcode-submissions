class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> group = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String sortedStr = new String (str);

            if(group.containsKey(sortedStr)){
                List<String> currGroup = group.get(sortedStr);
                currGroup.add(strs[i]);
            } else {
                group.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(strs[i]);
            }
        }

        for(List<String> groupStr : group.values()){
            result.add(groupStr);
        }

        return result;
    }
}