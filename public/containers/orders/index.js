import React, { Component } from 'react'
import { connect } from 'react-redux'
import { fetchOrders, createOrder, updateOrder, deleteOrder, getOrder, clearActualOrder, filterOrder } from '../../actions/ActionsOrder'
import { fetchProducts } from '../../actions/ActionsProduct'
import { fetchEmployeers } from '../../actions/ActionsEmployeer'
import { fetchAnimals } from '../../actions/ActionsAnimal'
import { openModal, closeModal } from '../../actions/ActionsModal'
import { Link } from 'react-router'

import OrderForm from './form'
import GridHeader from '../../components/GridHeader'


class Orders extends Component {

  componentWillMount() {
    if(!this.props.children) {
      this.props.fetchProducts();
      this.props.fetchEmployeers();
      this.props.fetchAnimals();
      this.props.fetchOrders();
    }
  }

  _buildModalStateToEdit() {
    return {
      modalTitle : "Editar Ordem de serviço",
      contentRender : () => { return (<OrderForm action={(order) => {
        ::this.props.closeModal()
        ::this.props.updateOrder(order)
      }}/>)},
      onModalUnmount : () => { ::this.props.clearActualOrder() }
    }
  }

  _buildModalStateToAdd() {
    return {
      modalTitle : "Adicionar Ordem de serviço",
      contentRender : () => { return (<OrderForm action={(order) => {
        ::this.props.closeModal()
        ::this.props.createOrder(order)
      }}/>)},
      onModalUnmount : () => { ::this.props.clearActualOrder() }
    }
  }

  render() {
    return (
      <div>
        <h3 className="title is-3">Ordens de Serviço</h3>
        <GridHeader
          openModal={ ()=> {
            ::this.props.clearActualOrder()
            ::this.props.openModal(this._buildModalStateToAdd())
          }}
          onChangeSearch={ (text) => {::this.props.filterOrder(text)}}
        />
        <div className="columns is-multiline">
          {this.props.order.all.filter(ob => ob.appointment.done == 0).map(( order ) => {
            let { employeers_id } = order.appointment.appointmentConfig;
            let employeer = this.props.employeer.all.reduce((acc, act) => {
              if(employeers_id == act.id)
                return act;
              return acc;
            });
            return (<div className="column is-half area-item animal-card" key={order.id}>
                <div className="card is-fullwidth">
                  <header className="card-header">
                    <p className="card-header-title">
                      { order.accessKey }
                   </p>
                  </header>
                  <div className="card-content">
                    <div className="media">
                      <div className="media-content">
                        <p>Pet: { order.appointment.pet.name }</p>
                        <p>Preço: { order.price }</p>
                        <p>Cliente: { order.appointment.pet.customer.name  + ' / ' + order.appointment.pet.customer.cpf}</p>
                        <p>Empregado responsável: { employeer.name }</p>
                      </div>
                    </div>
                  </div>
                  <footer className="card-footer">
                    <a className="card-footer-item" onClick={() => {this.props.deleteOrder(order)} }>Cancelar</a>
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
  return {
    employeer : state.employeersState,
    order : state.ordersState
  }
}

export default connect(mapStateToProps,
  { fetchOrders, getOrder, deleteOrder, createOrder, updateOrder, clearActualOrder, filterOrder, closeModal, openModal, fetchProducts, fetchEmployeers, fetchAnimals })(Orders)
