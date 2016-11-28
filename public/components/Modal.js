import React, { Component } from 'react'

import { closeModal } from '../actions/ActionsModal'

import { connect } from 'react-redux'
import { Link } from 'react-router'

class Modal extends Component {

  constructor(props){
    super(props)
  }

  render() {
    let { modal, closeModal } = this.props
    let { body } = modal;
    let isActiveClass = modal.isActive ? " is-active" : ""
    return (
      <div className={`modal${isActiveClass}`}>
        <div className="modal-background"  onClick={() => {closeModal()} }></div>
        <div className="modal-card">
          <header className="modal-card-head">
            <p className="modal-card-title">{ body.modalTitle }</p>
            <button className="delete"  onClick={() => {closeModal()} }></button>
          </header>
          <section className="modal-card-body">
            { body.contentRender() }
          </section>
        </div>
      </div>
    );
  }
}

function mapStateToProps(state) {
  return { modal : state.modal }
}

export default connect(mapStateToProps, { closeModal })(Modal)
