import '../styles/about.scss'

export default function About() {
  return (
    <div className="about">
      <div className="about-container">
        <h1 className="fade-in">About Us</h1>
        <div className="about-content fade-in-delay-1">
          <p>
            World of Words is a platform dedicated to enhancing vocabulary skills through 
            interactive games and challenges.
          </p>
          <p>
            Our mission is to make learning fun and accessible for everyone, helping users 
            expand their vocabulary in an engaging way.
          </p>
          <div className="team">
            <h2>Our Team</h2>
            <p>Created by passionate developers who love words and education.</p>
          </div>
        </div>
      </div>
    </div>
  )
}
