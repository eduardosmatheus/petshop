import React, { Component } from 'react'
import { Link } from 'react-router'

export default class GridHeader extends Component {
  constructor(props){
    super(props)
  }

  render() {
    return (
      <div className="columns">
        <div className="column is-2">
          <a className="button is-primary" onClick={() => {this.props.openModal()}}>Adicionar</a>
        </div>
        <div className="column is-9">
          <input className="input" type="text" placeholder="Pesquisar..." onChange={(event) => { ::this.props.onChangeSearch(event.target.value) }}/>
        </div>
        <div className="column is-1 search-icon-content">
          <div className="button is-white search-icon">
            <i className="fa fa-search " aria-hidden="true"></i>
          </div>
        </div>
      </div>
    );
  }
}
