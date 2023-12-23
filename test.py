def is_pair(cards):
    return len(set(cards)) == 2

def is_sequence(cards):
    return all(cards[i] == cards[i + 1] - 1 for i in range(len(cards) - 1))

def is_color(cards):
    return len(set(suit for _, suit in cards)) == 1

def is_trail(cards):
    return len(set(cards)) == 1

def teen_patti_winner(hand):
    hand.sort()

    if is_trail(hand):
        return "Trail"
    elif is_sequence(hand) and is_color(hand):
        return "Pure Sequence"
    elif is_sequence(hand):
        return "Sequence"
    elif is_color(hand):
        return "Color"
    elif is_pair(hand):
        return "Pair"
    else:
        return "High Card"

# Example usage:
player_hand = [(4, 'Hearts'), (7, 'Diamonds'), (8, 'Clubs')]
result = teen_patti_winner(player_hand)
print(f"Player has: {result}")
