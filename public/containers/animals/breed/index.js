import React, { Component } from 'react'
import { connect } from 'react-redux'
import { fetchBreeds, createBreed, updateBreed, deleteBreed, getBreed } from '../../../actions/ActionsBreed'
import { openModal } from '../../../actions/ActionsModal'
import { Link } from 'react-router'

import BreedForm from './form'
import GridHeader from '../../../components/GridHeader'


class Breeds extends Component {

  componentWillMount() {
    if(!this.props.children)
      this.props.fetchBreeds()
  }

  _buildModalStateToEdit(breed) {
    return {
      modalTitle : "Editar Raça",
      contentRender : (<BreedForm action={(breed) => { ::this.props.updateBreed(breed) }}/>)
    }
  }

  _buildModalStateToAdd(breed) {
    return {
      modalTitle : "Adicionar Raça",
      contentRender : (<BreedForm action={(breed) => {  ::this.props.createBreed(breed) }}/>)
    }
  }

  render() {
    return (
      <div> 
        <GridHeader openModal={ ()=> {
          ::this.props.openModal(this._buildModalStateToAdd())
        }}/>
        <div className="columns is-multiline">
          {this.props.breeds.all.map(( breed ) => {
            return (<div className="column is-one-third area-item animal-card" key={breed.id}>
                <div className="card is-fullwidth">
                  <div className="card-content">
                    <div className="media">
                      <div className="media-content">
                        <p>{ breed.name }</p>
                      </div>
                    </div>
                  </div>
                  <footer className="card-footer">
                    <a className="card-footer-item" onClick={() => {
                      this.props.getBreed(breed.id)
                      this.props.openModal(this._buildModalStateToEdit(breed))
                    }}>Edit</a>
                    <a className="card-footer-item" onClick={() => {this.props.deleteBreed(breed.id)} }>Delete</a>
                  </footer>
                </div>
              </div>) }
          )}
        </div>
      </div>
    );
  }
}

function mapStateToProps(state) {
  return { breeds : state.breedState }
}

export default connect(mapStateToProps,
  { fetchBreeds, getBreed, deleteBreed, openModal, createBreed, updateBreed })(Breeds)
