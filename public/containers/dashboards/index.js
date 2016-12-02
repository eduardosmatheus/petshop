import React, { Component } from 'react'
import { connect } from 'react-redux'
import { Link } from 'react-router'
import { fetchTotalPayments } from '../../actions/ActionsDashboard'

import AppointmentsPerDay from './appointmentsPerDay'

class Dashboard extends Component {
  render() {
    let { fields : graphics } = this.props
    console.log(this.props)

    return(
      <div className="columns">
        <div className="column"></div>

        <div className="column is-4">
          <div className="column">
            <div className="card is-fullwidth">
              <header className="card-header">
                <p className="card-header-title title is-5">
                  Pagamentos a receber
                </p>
              </header>
              <div className="card-content">
                <div className="content has-text-centered title is-1">
                  <p className="money-h">R$ {this.props.dashboard.totalPayments}</p>
                </div>
              </div>
            </div>
          </div>

          <div className = "column">
            <div className="card is-fullwidth">
              <header className="card-header">
                <p className="card-header-title title is-5">Total de atendimentos em aberto</p>
              </header>
              <div className="card-content">
                <div className="content has-text-centered title is-1">
                  {this.props.dashboard.appointmentsOpened}
                </div>
              </div>
            </div>
          </div>

          <div className="column">
            <div className="card is-fullwidth">
              <header className="card-header">
                <p className="card-header-title title is-5">Atendimentos para hoje:</p>
              </header>
              <div className="card-content">
                <div className="content has-text-centered title is-1">
                  {this.props.dashboard.appointmentsForToday}
                </div>
              </div>
            </div>
          </div>
        </div>

        <div className="column is-8">
          <div className="card is-fullwidth">
            <div className="card-content">
              <p className="card-header-title title is-5">Atendimentos na semana:</p>
              <AppointmentsPerDay/>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

function mapStateToProps(state) {
  return { dashboard : state.dashboardsState.views }
}

export default connect(mapStateToProps/*, { fetchTotalPayments }*/)(Dashboard);
