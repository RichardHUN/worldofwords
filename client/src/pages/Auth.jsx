import { useState } from 'react'
import '../styles/auth.scss'

export default function Auth() {
  const [isSignUp, setIsSignUp] = useState(false)

  return (
    <div className="auth">
      <div className="auth-container">
        <div className="auth-card fade-in">
          <h1>{isSignUp ? 'Sign Up' : 'Sign In'}</h1>
          <form className="auth-form">
            {isSignUp && (
              <div className="form-group">
                <label htmlFor="username">Username</label>
                <input type="text" id="username" placeholder="Choose a username" />
              </div>
            )}
            <div className="form-group">
              <label htmlFor="email">Email</label>
              <input type="email" id="email" placeholder="your@email.com" />
            </div>
            <div className="form-group">
              <label htmlFor="password">Password</label>
              <input type="password" id="password" placeholder="••••••••" />
            </div>
            <button type="submit" className="btn btn-auth">
              {isSignUp ? 'Sign Up' : 'Sign In'}
            </button>
          </form>
          <p className="auth-toggle">
            {isSignUp ? 'Already have an account?' : "Don't have an account?"}{' '}
            <button onClick={() => setIsSignUp(!isSignUp)}>
              {isSignUp ? 'Sign In' : 'Sign Up'}
            </button>
          </p>
        </div>
      </div>
    </div>
  )
}
