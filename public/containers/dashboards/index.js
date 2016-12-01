import React, { Component } from 'react'
import { connect } from 'react-redux'
import { Link } from 'react-router'

import { fetchBillingTotals } from '../../actions/ActionsDashboard'

class Dashboard extends Component {
  render() {
    let { fields : billingsTotal } = this.props
    return(
      <div>
        <h3 className="title is-3">Acompanhamento</h3>
        <div className="columns">
          <div className="column">
            <div className="card is fullwidth">
              <header className="card-header">
                <p className="card-header-title">
                  Total ganho com ordens de serviço
                </p>
              </header>
              <div className="card-content">
                <div className="content">
                  R$: {this.props.fetchBillingTotals()}
                </div>
              </div>
            </div>
          </div>
          <div className="column">
            <div>outro gráfico</div>
          </div>
          <div className="column">
            <div>outro gráfico</div>
          </div>

        </div>
      </div>
    );
  }
}

function mapStateToProps(state) {
  return { dashboard : state.dashboardsState.actual }
}

export default connect(mapStateToProps, { fetchBillingTotals })(Dashboard);
