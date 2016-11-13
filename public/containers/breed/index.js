import React, { Component } from 'react'
import { connect } from 'react-redux'
import { fetchBreeds, createBreed } from '../../actions/ActionsBreed'
import BreedForm from './BreedForm'
import { Link } from 'react-router'

class Breeds extends Component {

  componentWillMount() {
    this.props.fetchBreeds()
  }

  renderBreeds() {
    return this.props.breeds.all.map((breed) => {
      return (
        <tr key={breed.id}>
          <td>{breed.id}</td>
          <td>{breed.name}</td>
          <td>
            <Link to="/breedsnew" params={{breedId : breed.id}}>
              <button className="btn btn-warning">
              Editar
              </button>
            </Link>
          </td>
        </tr>)
    })
  }

  render() {
    let { actual, children } = this.props.breeds
    return (
      <div>

        <table className="table table-striped table-hover ">
          <thead>
            <tr>
              <th>Id</th>
              <th>Nome</th>
              <th></th>
              <th></th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            {this.renderBreeds()}
          </tbody>
        </table>
      </div>
    );
  }
}

function mapStateToProps(state) {
  return { breeds : state.breedState }
}

export default connect(mapStateToProps, { fetchBreeds })(Breeds)
