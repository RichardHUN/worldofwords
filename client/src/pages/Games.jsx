import '../styles/games.scss'

export default function Games() {
  return (
    <div className="games">
      <div className="games-container">
        <h1 className="fade-in">Games</h1>
        <div className="games-grid">
          <div className="game-card fade-in-delay-1">
            <h3>Letteristic</h3>
            <p>Get a random letter from the alphabet, then name cities, objects, and more starting with it. You have limited time so be fast! You get more points if you guess quickly.</p>
            <button className="btn">Play Now</button>
          </div>
          <div className="game-card fade-in-delay-2">
            <h3>Wordle</h3>
            <p>Get a random 5-letter word and try to guess it by placing letters in the boxes. Each correctly placed letter will turn green, and if the word contains the letter but it's not well placed, it will turn yellow.</p>
            <button className="btn">Play Now</button>
          </div>
          <div className="game-card fade-in-delay-3">
            <h3>ColorCrush</h3>
            <p>Get a random combination of colors, and you need to guess the correct order. When you guessed a color correctly, a bubble of the four will turn black. When a color is included but not in the right position, it will turn white.</p>
            <button className="btn">Play Now</button>
          </div>
        </div>
      </div>
    </div>
  )
}
