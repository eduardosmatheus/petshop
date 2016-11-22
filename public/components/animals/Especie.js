import React, { Component } from 'react'
import { Link } from 'react-router'

export default class Especie extends Component {
  constructor(props){
    super(props)
  }

  render() {

    return (
      <div className="column is-one-third area-item animal-card">
        <div className="card is-fullwidth">
          <div className="card-content">
            <div className="media">
              <div className="media-content">
                <p>TESTE</p>
              </div>
            </div>
          </div>
          <footer className="card-footer">
            <a className="card-footer-item">Edit</a>
            <a className="card-footer-item">Delete</a>
          </footer>
        </div>
      </div>
    )
  }
}
