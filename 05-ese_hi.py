import collections

for i in range(int(input())):
    values = collections.defaultdict(int)
    for _ in range(int(input())):
        input1 = input()

        if input1.startswith("top"):
            b = int(input1[4:])
            if b > len(values):
                b = len(values)
            temp_dict = dict(sorted(values.items()))
            for key, value in sorted(temp_dict.items(), key=lambda k_v: k_v[1], reverse=True):
                if b <= 0:
                    break
                print(key,end=' ')
                b = b-1
            print()
        else:
            values[input1] += 1

    # for _ in range(int(input())):
    #     print(values[input()])