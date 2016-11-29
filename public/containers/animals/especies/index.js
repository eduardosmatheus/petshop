import React, { Component } from 'react'
import { connect } from 'react-redux'
import { fetchEspecies, createEspecie, updateEspecie, deleteEspecie, getEspecie, clearActualEspecie, filterEspecie } from '../../../actions/ActionsEspecie'
import { openModal, closeModal } from '../../../actions/ActionsModal'
import { Link } from 'react-router'

import EspecieForm from './form'
import GridHeader from '../../../components/GridHeader'


class especies extends Component {

  componentWillMount() {
    if(!this.props.children)
      this.props.fetchEspecies()
  }

  _buildModalStateToEdit() {
    return {
      modalTitle : "Editar Especie",
      contentRender : () => { return (<EspecieForm action={(especie) => {
        ::this.props.closeModal()
        ::this.props.updateEspecie(especie)
      }}/>)},
      onModalUnmount : () => { ::this.props.clearActualEspecie() }
    }
  }

  _buildModalStateToAdd() {
    return {
      modalTitle : "Adicionar Especie",
      contentRender : () => { return (<EspecieForm action={(especie) => {
        ::this.props.closeModal()
        ::this.props.createEspecie(especie)
      }}/>)},
      onModalUnmount : () => { ::this.props.clearActualEspecie() }
    }
  }

  render() {
    return (
      <div>
        <GridHeader
          openModal={ ()=> {
            ::this.props.clearActualEspecie()
            ::this.props.openModal(this._buildModalStateToAdd())
          }}
          onChangeSearch={ (text) => {::this.props.filterEspecie(text)}}
        />
        <div className="columns is-multiline">
          {this.props.especies.all.map(( especie ) => {
            return (<div className="column is-one-third area-item animal-card" key={especie.id}>
                <div className="card is-fullwidth">
                  <div className="card-content">
                    <div className="media">
                      <div className="media-content">
                        <p>{ especie.description }</p>
                      </div>
                    </div>
                  </div>
                  <footer className="card-footer">
                    <a className="card-footer-item" onClick={() => {
                      this.props.getEspecie(especie.id)
                      this.props.openModal(this._buildModalStateToEdit())
                    }}>Edit</a>
                    <a className="card-footer-item" onClick={() => {this.props.deleteEspecie(especie)} }>Delete</a>
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
  return { especies : state.especieState }
}

export default connect(mapStateToProps,
  { fetchEspecies, getEspecie, deleteEspecie, createEspecie, updateEspecie, clearActualEspecie, filterEspecie, closeModal, openModal })(especies)
