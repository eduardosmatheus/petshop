import React, { Component } from 'react'
import { connect } from 'react-redux'
import { fetchAppointments, createAppointment, updateAppointment, deleteAppointment, getAppointment, clearActualAppointment, filterAppointment } from '../../actions/ActionsAppointments'
import { openModal, closeModal } from '../../actions/ActionsModal'
import { Link } from 'react-router'

import AppointmentForm from './form'
import GridHeader from '../../components/GridHeader'


class Appointments extends Component {

  componentWillMount() {
    if(!this.props.children)
      this.props.fetchAppointments()
  }

  _buildModalStateToEdit() {
    return {
      modalTitle : "Editar Cliente",
      contentRender : () => { return (<AppointmentForm action={(appointment) => {
        ::this.props.closeModal()
        ::this.props.updateAppointment(appointment)
      }}/>)},
      onModalUnmount : () => { ::this.props.clearActualAppointment() }
    }
  }

  _buildModalStateToAdd() {
    return {
      modalTitle : "Adicionar Cliente",
      contentRender : () => { return (<AppointmentForm action={(appointment) => {
        ::this.props.closeModal()
        ::this.props.createAppointment(appointment)
      }}/>)},
      onModalUnmount : () => { ::this.props.clearActualAppointment() }
    }
  }


  _renderChildrens() {
    if(this.props.children)
      return (<div>{this.props.children}</div>)

    let { all } = this.props.appointments;
    return  (
      <div>
        <GridHeader
          openModal={ ()=> {
            ::this.props.clearActualAppointment();
            ::this.props.openModal(this._buildModalStateToAdd());
          }}
          onChangeSearch={ (text) => {::this.props.filterAppointment(text)}}
        />
        <div className="columns is-multiline">
          TESTE
        </div>
      </div>)
  }

  render() {
    let { pathname } = this.props.location
    return (<div>
              <h3 className="title is-3">Recursos Humanos</h3>
              <div className="tabs is-centered is-boxed is-medium">
                <ul>
                  <li className={pathname == '/appointments' ? 'is-active' : ''}>
                    <Link to="/appointments">
                      <span>Agendamentos Pendentes</span>
                    </Link>
                  </li>
                  <li className={pathname == '/appointments/employeers' ? 'is-active' : ''}>
                    <Link to="/appointments/employeers">
                      <span>Empregados</span>
                    </Link>
                  </li>
                </ul>
              </div>
              <div className="container">
                {this._renderChildrens()}
              </div>
            </div>)
  }
}

function mapStateToProps(state) {
  return { appointments : state.appointmentsState }
}

export default connect(mapStateToProps,
  { fetchAppointments, getAppointment, deleteAppointment, createAppointment, updateAppointment, clearActualAppointment, filterAppointment, closeModal, openModal })(Appointments)
