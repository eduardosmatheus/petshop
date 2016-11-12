import React, { Component } from 'react'
import { connect } from 'react-redux'
import { changeState } from '../actions'
import { bindActionCreators } from 'redux'

class Breeds extends Component {

  renderBreeds() {
    return this.props.breeds.map((breed) => {
      return (<tr key={breed.id} onClick={() => {this.props.changeState(breed)}}><td>{breed.id}</td><td>{breed.name}</td></tr>)
    })
  }

  render() {
    return (
      <table className="table table-striped table-hover ">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nome</th>
          </tr>
        </thead>
        <tbody>
          {this.renderBreeds()}
        </tbody>
      </table>
    );
  }
}

function mapStateToProps(state) {
  return { breeds : state.breeds }
}

function mapDispatchToProps(dispatch) {
  return bindActionCreators({ changeState : changeState }, dispatch);
}

export default connect(mapStateToProps, mapDispatchToProps)(Breeds)
