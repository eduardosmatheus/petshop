import React, { Component } from 'react'
import { connect } from 'react-redux'
import { fetchBreeds, deleteBreed } from '../../../actions/ActionsBreed'
import EspecieForm from './EspecieForm'
import { Link } from 'react-router'

import EspecieComp from '../../../components/animals/especie'

class Especies extends Component {

  componentWillMount() {
    if(!this.props.children)
      this.props.fetchBreeds()
  }

  render() {
    return (
      <div className="columns is-multiline">
        {this.props.breeds.all.map(( breed ) => {
          return (<EspecieComp
            key={breed.id}
            breed={breed}
            del={::this.props.deleteBreed} />)
          }
        )}
      </div>
    );
  }
}

function mapStateToProps(state) {
  return { breeds : state.breedState }
}

export default connect(mapStateToProps, { fetchBreeds, deleteBreed })(Especies)
