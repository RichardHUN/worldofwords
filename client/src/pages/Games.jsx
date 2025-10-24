import '../styles/games.scss'

export default function Games() {
  return (
    <div className="games">
      <div className="games-container">
        <h1 className="fade-in">Games</h1>
        <div className="games-grid">
          <div className="game-card fade-in-delay-1">
            <h3>Word Match</h3>
            <p>Match words with their definitions</p>
            <button className="btn">Play Now</button>
          </div>
          <div className="game-card fade-in-delay-2">
            <h3>Vocabulary Quiz</h3>
            <p>Test your vocabulary knowledge</p>
            <button className="btn">Play Now</button>
          </div>
          <div className="game-card fade-in-delay-3">
            <h3>Spelling Challenge</h3>
            <p>Improve your spelling skills</p>
            <button className="btn">Play Now</button>
          </div>
        </div>
      </div>
    </div>
  )
}
