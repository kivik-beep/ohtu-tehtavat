class TennisGame:
    def __init__(self, player1_name, player2_name):
        self.player1_name = player1_name
        self.player2_name = player2_name
        self.m_score1 = 0
        self.m_score2 = 0

    def won_point(self, player_name):
        if player_name == "player1":
            self.m_score1 = self.m_score1 + 1
        else:
            self.m_score2 = self.m_score2 + 1

    def get_score(self):
        score = ""

        if self.m_score1 == self.m_score2:
            score = self.even_score(self.m_score1)

        elif self.m_score1 >= 4 or self.m_score2 >= 4:
            score = self.endgame_score(self.m_score1 - self. m_score2)
        else:
            score = self.score(self.m_score1, self.m_score2)
        return score

    def even_score(self, score1):
        score = {
                0 : "Love-All",
                1 : "Fifteen-All",
                2 : "Thirty-All",
                3 : "Forty-all"
            }.get(score1, "Deuce")
        return score
    
    def endgame_score(self, difference):
        if difference == 1:
            score = "Advantage player1"
        elif difference == -1:
            score = "Advantage player2"
        elif difference >= 2:
            score = "Win for player1"
        else:
            score = "Win for player2"
        return score

    def score(self, score1, score2):
        words = {
            0 : "Love",
            1 : "Fifteen",
            2 : "Thirty",
            3 : "Forty"
        }  
        return words[score1]+ "-" + words[score2]

