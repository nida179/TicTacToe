# Tic Tac Toe 🎮

A classic Tic Tac Toe game built in Java with a dark-themed Swing UI. Play against a random AI and try to win!

---

## Features

- Player vs AI gameplay
- Dark themed UI with colored X and O marks
- Winning cells highlighted in green
- Reset button to start a new game
- AI responds after a short delay for a natural feel

---

## How to Run

### Requirements
- Java JDK 8 or higher
- IntelliJ IDEA (recommended) or any Java IDE

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/TicTacToe.git
   ```
2. Open the project in IntelliJ IDEA
3. Run `Main.java` or `GameView.java`

---

## Project Structure

```
TicTacToe/
├── src/
│   ├── Mark.java            # Enum for X, O, EMPTY
│   ├── Board.java           # Grid logic, win/draw detection
│   ├── Player.java          # Player interface
│   ├── HumanPlayer.java     # Human player
│   ├── AIPlayer.java        # Random AI player
│   ├── GameController.java  # Controls game flow and turns
│   └── GameView.java        # Swing UI
```

---

## How It Works

The project follows a clean **MVC-inspired structure**:

- **Model** — `Board`, `Mark`, `Player` classes handle all game logic with zero UI dependency
- **Controller** — `GameController` manages turns, validates moves, and triggers the AI
- **View** — `GameView` renders the board and reacts to user clicks via `ActionListener`

---

## What I Learned

- Designing classes using **OOP principles** (Single Responsibility, Interfaces)
- Using **enums** for type-safe game state
- Building desktop UIs with **Java Swing** (JFrame, JPanel, GridLayout, BorderLayout)
- Handling UI events with **ActionListener** and **Lambda expressions**
- Separating game logic from UI for cleaner, maintainable code

---

## Future Improvements

- [ ] Minimax AI (unbeatable)
- [ ] Player vs Player mode
- [ ] Score tracker
- [ ] Animations and sound effects

---

## Built With

- Java
- Java Swing

---

*Built as a learning project to practice OOP design and Swing UI in Java.*
