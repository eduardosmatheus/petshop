import React, { Component } from 'react'
import { connect } from 'react-redux'
import { fetchBreeds } from '../../actions'

class Breeds extends Component {
  componentWillMount() {
    this.props.fetchBreeds()
  }

  renderBreeds() {
    let {all} = this.props.breeds
    return all.map((breed) => {
      return (<tr key={breed.id}><td>{breed.id}</td><td>{breed.name}</td></tr>)
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
  return { breeds : state.breedState }
}

export default connect(mapStateToProps, { fetchBreeds })(Breeds)
