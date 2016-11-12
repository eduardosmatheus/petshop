import React, { Component } from 'react'
import { connect } from 'react-redux'
import { changeState } from '../actions'
import { bindActionCreators } from 'redux'

class Breeds extends Component {

  render() {
    return (
      <div>
        {this.props.changeState.name}
      </div>
    );
  }
}

function mapStateToProps(state) {
  return { changeState : state.changeState }
}

export default connect(mapStateToProps)(Breeds)
