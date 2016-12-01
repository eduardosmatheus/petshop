import React, { Component } from 'react'
import { connect } from 'react-redux'
import { fetchEmployeers, createEmployeer, updateEmployeer, deleteEmployeer, getEmployeer, clearActualEmployeer, filterEmployeer } from '../../../actions/ActionsEmployeer'
import { openModal, closeModal } from '../../../actions/ActionsModal'
import { Link } from 'react-router'

import EmployeerForm from './form'
import GridHeader from '../../../components/GridHeader'


class Employeers extends Component {

  componentWillMount() {
    if(!this.props.children)
      this.props.fetchEmployeers()
  }

  _buildModalStateToEdit() {
    return {
      modalTitle : "Editar Empregado",
      contentRender : () => { return (<EmployeerForm action={(employeer) => {
        ::this.props.closeModal()
        ::this.props.updateEmployeer(employeer)
      }}/>)},
      onModalUnmount : () => { ::this.props.clearActualEmployeer() }
    }
  }

  _buildModalStateToAdd() {
    return {
      modalTitle : "Adicionar Empregado",
      contentRender : () => { return (<EmployeerForm action={(employeer) => {
        ::this.props.closeModal()
        ::this.props.createEmployeer(employeer)
      }}/>)},
      onModalUnmount : () => { ::this.props.clearActualEmployeer() }
    }
  }

  render() {
    return (
      <div>
        <GridHeader
          openModal={ ()=> {
            ::this.props.clearActualEmployeer()
            ::this.props.openModal(this._buildModalStateToAdd())
          }}
          onChangeSearch={ (text) => {::this.props.filterEmployeer(text)}}
        />
        <div className="columns is-multiline">
          {this.props.employeer.all.map(( employeer ) => {
            return (<div className="column is-one-third area-item animal-card" key={employeer.id}>
                <div className="card is-fullwidth">
                <header className="card-header">
                  <p className="card-header-title">
                    { employeer.name }
                 </p>
                </header>
                  <div className="card-content">
                    <div className="media">
                      <div className="media-content">
                        <p>CPF: { employeer.cpf }</p>
                        <i className="fa fa-phone" aria-hidden="true"/> { employeer.phone }
                        <br/>
                        <i className="fa fa-envelope" aria-hidden="true"/>{ employeer.email }
                      </div>
                    </div>
                  </div>
                  <footer className="card-footer">
                    <a className="card-footer-item" onClick={() => {
                      this.props.getEmployeer(employeer.id)
                      this.props.openModal(this._buildModalStateToEdit())
                    }}>Edit</a>
                    <a className="card-footer-item" onClick={() => {this.props.deleteEmployeer(employeer)} }>Delete</a>
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
  return { employeer : state.employeersState }
}

export default connect(mapStateToProps,
  { fetchEmployeers, getEmployeer, deleteEmployeer, createEmployeer, updateEmployeer, clearActualEmployeer, filterEmployeer, closeModal, openModal })(Employeers)
