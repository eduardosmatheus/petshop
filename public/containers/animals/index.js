import React, { Component } from 'react'
import { connect } from 'react-redux'
import { Link } from 'react-router'
import Animal from '../../components/animals/Animal'
import GridHeader from '../../components/GridHeader'

class Animals extends Component {

  _renderChildrens() {
    if(this.props.children)
      return (<div>{this.props.children}</div>)

    let { all } = this.props.animals
    return  (
      <div className="columns is-multiline">
        {all.map((pet, i) => {
          //TODO: mudar key de i pelo ID do pet.
          return (<Animal key={i} pet={pet} /> )
        })}
      </div>)
  }


  render() {
    let { pathname } = this.props.location
    return (<div>
              <div className="tabs is-centered is-boxed is-medium">
                <ul>
                  <li className={pathname == '/animals' ? 'is-active' : ''}>
                    <Link to="/animals">
                      <span>Pets</span>
                    </Link>
                  </li>
                  <li className={pathname == '/animals/breeds' ? 'is-active' : ''}>
                    <Link to="/animals/breeds">
                      <span>Raças</span>
                    </Link>
                  </li>
                  <li className={pathname == '/animals/especies' ? 'is-active' : ''}>
                    <Link to="/animals/especies">
                      <span>Especies</span>
                    </Link>
                  </li>
                </ul>
              </div>
              <div className="container">
                {this._renderChildrens()}
              </div>
            </div>)
  }
}

function mapStateToProps(state) {
  return { animals : state.animals }
}

export default connect(mapStateToProps, {  })(Animals)
