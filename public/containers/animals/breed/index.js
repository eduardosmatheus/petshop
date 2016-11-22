import React, { Component } from 'react'
import { connect } from 'react-redux'
import { fetchBreeds, deleteBreed } from '../../../actions/ActionsBreed'
import { openModal } from '../../../actions/ActionsModal'
import { Link } from 'react-router'

import BreedComp from '../../../components/animals/breed'

class Breeds extends Component {

  componentWillMount() {
    if(!this.props.children)
      this.props.fetchBreeds()
  }

  render() {
    return (
      <div className="columns is-multiline">
        {this.props.breeds.all.map(( breed ) => {
          return (<BreedComp
            key={breed.id}
            breed={breed}
            del={::this.props.deleteBreed}
            openModal={::this.props.openModal}/>)
          }
        )}
      </div>
    );
  }
}

function mapStateToProps(state) {
  return { breeds : state.breedState }
}

export default connect(mapStateToProps,
  { fetchBreeds, deleteBreed, openModal })(Breeds)
