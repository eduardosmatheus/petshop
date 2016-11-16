import React, { Component } from 'react'
import { connect } from 'react-redux'
// import { fetchPets } from '../../actions/ActionsAnimals'
import { Link } from 'react-router'

class Breeds extends Component {

  componentWillMount() {
  }

  render() {
    if(this.props.children)
      return (<div>{ this.props.children }</div>)

    return (
      <div>
        <table className="table table-striped table-hover ">
          <thead>
            <tr>
              <th>Id</th>
              <th>Nome</th>
              <th></th>
              <th></th>
            </tr>
          </thead>
          <tbody> 
          </tbody>
        </table>
      </div>
    );
  }
}

function mapStateToProps(state) {
  return { animals : state.animals }
}

export default connect(mapStateToProps, {  })(Breeds)
