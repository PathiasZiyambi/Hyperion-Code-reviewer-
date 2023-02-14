# import defaultdict from the collections to store the results
from collections import defaultdict

# groupAnagrams function takes in an array of strings 'strs' as input
def groupAnagrams(strs):
    # initialize an empty defaultdict called 'answer' which will store the results
    answer = defaultdict(list)
    # each string 's' in 'strs', we create a list 'count' of 26 integers to keep track of the frequency of each letter
    for s in strs:
        count = [0] * 26
        # each character 'c' in 's', we increment the count at the corresponding index, which is 'ord(c) - ord('a').
        for c in s:
            count[ord(c) - ord('a')] += 1
        # use list 'count' as the key and 's' as the value, and append 's' to the list stored at this key in 'ans'.
        answer[tuple(count)].append(s)
    # return the values of answer
    return list(answer.values())

strs = ["eat","tea","tan","ate","nat","bat"]
# print groupAnagrams for strs
print(groupAnagrams(strs))