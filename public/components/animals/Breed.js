import React, { Component } from 'react'
import { Link } from 'react-router'

export default class Breed extends Component {
  constructor(props){
    super(props)
  }

  _buildModalStateToEdit() {
    let { breed, openModal } = this.props;
    return {
      modalTitle : "Editar Raça",
      contentRender : () => {
        return <div> { breed.name } </div>
      },
      saveBtnAction : () => {

      }
    }
  }

  render() {
    let { breed, openModal, del } = this.props; 
    return (
      <div className="column is-one-third area-item animal-card">
        <div className="card is-fullwidth">
          <div className="card-content">
            <div className="media">
              <div className="media-content">
                <p>   { breed.name }</p>
              </div>
            </div>
          </div>
          <footer className="card-footer">
            <a className="card-footer-item" onClick={() => {openModal(this._buildModalStateToEdit())}}>Edit</a>
            <a className="card-footer-item" onClick={() => {del(breed.id)} }>Delete</a>
          </footer>
        </div>
      </div>
    )
  }
}
