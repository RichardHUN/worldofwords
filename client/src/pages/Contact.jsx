import '../styles/contact.scss'

export default function Contact() {
  return (
    <div className="contact">
      <div className="contact-container">
        <h1 className="fade-in">Contact Us</h1>
        <form className="contact-form fade-in-delay-1">
          <div className="form-group">
            <label htmlFor="name">Name</label>
            <input type="text" id="name" placeholder="Your name" />
          </div>
          <div className="form-group">
            <label htmlFor="email">Email</label>
            <input type="email" id="email" placeholder="your@email.com" />
          </div>
          <div className="form-group">
            <label htmlFor="message">Message</label>
            <textarea id="message" rows="5" placeholder="Your message"></textarea>
          </div>
          <button type="submit" className="btn btn-submit">Send Message</button>
        </form>
      </div>
    </div>
  )
}
