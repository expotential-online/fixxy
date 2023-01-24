package fixxy.core.subinterface

import fixxy.core.Synopsis

/**
 * Implementor has a human-readable synopsis
 */
interface HasSynopsis {

  /**
   * @return A huma-readable synopsis
   */
  fun synopsis(): Synopsis
}