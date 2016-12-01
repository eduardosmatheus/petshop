import React, { Component } from 'react'
import { Link } from 'react-router'

export default class MenuApp extends Component {
  render() {
    return (
      <div className="menu-app">
        <div className="tile is-ancestor">
          <div className="tile is-vertical is-8">
            <div className="tile">
              <div className="tile is-parent is-vertical">
                <Link className="tile is-child menu-item" to="/appointments" style={{backgroundColor : '#0A7DC5'}}>
                  <div className="menu-item-content">
                    <i className="fa fa-calendar"/>
                    <p className="title menu-app-description">Agendas</p>
                  </div>
                </Link>
                <Link className="tile is-child menu-item" to="/customers" style={{backgroundColor : '#0AB7CF'}}>
                  <div className="menu-item-content">
                    <i className="fa fa-users fa-5x"/>
                    <p className="title menu-app-description">Clientes</p>
                  </div>
                </Link>
              </div>
              <div className="tile is-parent">
                <Link className="tile is-child menu-item" to="/orders" style={{backgroundColor : '#00B89C'}}>
                  <div className="menu-item-content">
                    <i className="fa fa-cogs fa-5x"/>
                    <p className="title menu-app-description">Ordens de serviço</p>
                  </div>
                </Link>
              </div>
            </div>
            <div className="tile is-parent">
              <Link className="tile is-child menu-item" to="/products" style={{backgroundColor : '#0ACF79'}}>
                <div className="menu-item-content">
                  <i className="fa fa-barcode fa-5x"/>
                  <p className="title menu-app-description">Produtos</p>
                </div>
              </Link>
            </div>
          </div>
          <div className="tile is-parent is-vertical">
            <Link className="tile is-child menu-item" to="/animals"  style={{backgroundColor : '#0AC53F'}}>
              <div className="menu-item-content">
                <i className="fa fa-qq fa-5x"/>
                <p className="title menu-app-description">Animais</p>
              </div>
            </Link>
            <Link className="tile is-child menu-item" to="/dashboards" style={{backgroundColor : '#0A4CC5'}}>
              <div className="menu-item-content">
                <i className="fa fa-area-chart fa-5x"/>
                <p className="title menu-app-description">Dashboards</p>
              </div>
            </Link>
          </div>
        </div>
      </div>)
  }
}
