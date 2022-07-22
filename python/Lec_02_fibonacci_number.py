def calc_fibonacci_using_memorization(n):
    assert int(n) == n and n >= 0, "Fibonacci Number should be an whole number"
    memory = [-1 for i in range(0, n + 1)]
    memory[0] = 0
    memory[1] = 1
    calc_fibonacci_using_memorization_util(n, memory)
    return memory[n]


def calc_fibonacci_using_memorization_util(n, memory):
    if n == 0:
        return 0
    if n == 1:
        return 1
    if memory[n] == -1:
        memory[n] = calc_fibonacci_using_memorization_util(
            n - 1, memory) + calc_fibonacci_using_memorization_util(n - 2, memory)

    return memory[n]


print(calc_fibonacci_using_memorization(5))
