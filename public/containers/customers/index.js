import React, { Component } from 'react'
import { connect } from 'react-redux'
import { fetchCustomers, createCustomer, updateCustomer, deleteCustomer, getCustomer, clearActualCustomer, filterCustomer } from '../../actions/ActionsCustomer'
import { openModal, closeModal } from '../../actions/ActionsModal'
import { Link } from 'react-router'

import CustomerForm from './form'
import GridHeader from '../../components/GridHeader'


class Customers extends Component {

  componentWillMount() {
    if(!this.props.children)
      this.props.fetchCustomers()
  }

  _buildModalStateToEdit() {
    return {
      modalTitle : "Editar Cliente",
      contentRender : () => { return (<CustomerForm action={(customer) => {
        ::this.props.closeModal()
        ::this.props.updateCustomer(customer)
      }}/>)},
      onModalUnmount : () => { ::this.props.clearActualCustomer() }
    }
  }

  _buildModalStateToAdd() {
    return {
      modalTitle : "Adicionar Cliente",
      contentRender : () => { return (<CustomerForm action={(customer) => {
        ::this.props.closeModal()
        ::this.props.createCustomer(customer)
      }}/>)},
      onModalUnmount : () => { ::this.props.clearActualCustomer() }
    }
  }

  render() {
    return (
      <div>
        <GridHeader
          openModal={ ()=> {
            ::this.props.clearActualCustomer()
            ::this.props.openModal(this._buildModalStateToAdd())
          }}
          onChangeSearch={ (text) => {::this.props.filterCustomer(text)}}
        />
        <div className="columns is-multiline">
          {this.props.customer.all.map(( customer ) => {
            return (<div className="column is-one-third area-item animal-card" key={customer.id}>
                <div className="card is-fullwidth">
                  <div className="card-content">
                    <div className="media">
                      <div className="media-content">
                        <p>{ customer.name }</p>
                      </div>
                    </div>
                  </div>
                  <footer className="card-footer">
                    <a className="card-footer-item" onClick={() => {
                      this.props.getCustomer(customer.id)
                      this.props.openModal(this._buildModalStateToEdit())
                    }}>Edit</a>
                    <a className="card-footer-item" onClick={() => {this.props.deleteCustomer(customer)} }>Delete</a>
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
  return { customer : state.customerState }
}

export default connect(mapStateToProps,
  { fetchCustomers, getCustomer, deleteCustomer, createCustomer, updateCustomer, clearActualCustomer, filterCustomer, closeModal, openModal })(Customers)
