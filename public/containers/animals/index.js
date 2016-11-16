import React, { Component } from 'react'
import { connect } from 'react-redux'
// import { fetchPets } from '../../actions/ActionsBreed'
import { Link } from 'react-router'

class Breeds extends Component {

  componentWillMount() {
  }

  render() {
    if(this.props.children)
      return (<div>{ this.props.children }</div>)
      
    return (
      <div>
       Hello world
      </div>
    );
  }
}

function mapStateToProps(state) {
  return { animals : state.animals }
}

export default connect(mapStateToProps, {  })(Breeds)
