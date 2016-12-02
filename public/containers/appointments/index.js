import React, { Component } from 'react'
import { connect } from 'react-redux'
import { fetchEmployeers } from '../../actions/ActionsEmployeer'
import { fetchAppointments, createAppointment, updateAppointment, deleteAppointment, getAppointment, clearActualAppointment, filterAppointments } from '../../actions/ActionsAppointments'
import { openModal, closeModal } from '../../actions/ActionsModal'
import { parseTimeStringFormatToMillisecods, parseMillisecodsToTimeStringFormat } from '../../dateParser'
import { Link } from 'react-router'

import AppointmentForm from './form'
import GridHeader from '../../components/GridHeader'


class Appointments extends Component {

  componentWillMount() {
    if(!this.props.children) {
      this.props.fetchEmployeers();
      this.props.fetchAppointments();
    }
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
    console.log(all);
    return  (
      <div>
        <GridHeader
          openModal={ ()=> {
            ::this.props.clearActualAppointment();
            ::this.props.openModal(this._buildModalStateToAdd());
          }}
          onChangeSearch={ (text) => {::this.props.filterAppointments(text)}}
        />
        <div className="columns is-multiline">
          {all.filter(ap => ap.done == 0).map((appointment) => {
            console.log(appointment);
            return (<div className="column is-one-third area-item animal-card" key={appointment.id}>
                <div className="card is-fullwidth">
                <header className="card-header">
                  <p className="card-header-title">
                    { appointment.date + ' - ' + this.props.employeersState.all.reduce((acc, act) => {
                      if(act.id == appointment.appointmentConfig.employeers_id)
                        return act;
                      return acc;
                    },  { id: 0, name: ''}).name}
                 </p>
                </header>
                  <div className="card-content">
                    <div className="media">
                      <div className="media-content">
                        <p>Horário inicio: { parseMillisecodsToTimeStringFormat(appointment.entryTime) }</p>
                        <p>Horário fim:{ parseMillisecodsToTimeStringFormat(appointment.outTime) }</p>
                        <strong>Pet: { appointment.pet.name }</strong>
                        <p>Cliente: { appointment.pet.customer.name + ' / ' + appointment.pet.customer.cpf}</p>
                        <p>Fone: { appointment.pet.customer.phone }</p>
                        { appointment.pet.obs && <p><strong>Obs:</strong> { appointment.pet.obs }</p>}
                      </div>
                    </div>
                  </div>
                  <footer className="card-footer">
                    <a className="card-footer-item" onClick={() => {this.props.updateAppointment(appointment.id)} }>Concluir</a>
                  </footer>
                </div>
              </div>);
          })}
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
  return {
    employeersState: state.employeersState,
    appointments : state.appointmentsState
  }
}

export default connect(mapStateToProps,
  { fetchAppointments, getAppointment, deleteAppointment, createAppointment, updateAppointment, clearActualAppointment, filterAppointments, closeModal, openModal, fetchEmployeers })(Appointments)
