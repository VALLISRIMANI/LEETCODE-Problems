class Solution:
    def frequencySort(self, s: str) -> str:
        freq = {}

        for ch in s:
            freq[ch] = freq.get(ch, 0) + 1
        
        sorted_freq = dict(sorted(freq.items(), key=lambda item: item[1], reverse=True))

        result = []
        for ch, count in sorted_freq.items():
            result.append(ch * count)

        return "".join(result)