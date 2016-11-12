import React, { Component } from 'react'
import { Link } from 'react-router'

export default class MenuApp extends Component {
  render() {
    return (
      <div>
        <Link to="/breeds" >
          <span>Go Breeds</span>
          <i className="fa fa-qq"/>
        </Link>
      </div>)
  }
}
